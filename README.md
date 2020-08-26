![version](https://img.shields.io/badge/version-1.0.0-green.svg)

# Infrastructure Ansible Jenkins
## Introduction
This repository contains all the script you need to build, deploy and backup a jenkins using
docker. Our Jenkins image is based on [this one.](https://hub.docker.com/r/jenkins/jenkins/)

## Repo explanations
### Inventory
The inventory folder contains the url on which you want to deploy your docker, backup your data and
store your docker image. These url are divided in several group (under [] in the hosts files). Variables
can be assigned to group in the group_vars file, and will be accessible by ansible during runtime.

#### Inventory Group Glossary
##### dockerserver
The url to the server running the docker registry and from which we pull and push our custom
jenkins image.

##### filerserver
The server on which the backup of Jenkins are made and retrieved.

##### jenkinsserver
The server on which Jenkins is running.

##### automationserver
The list of server on which we need an automation user (the filer and jenkins server). The
automation user is used for the majority of the roles. It avoid using directly the root user
and as limited rights.
The automation user can also be used to launch the ansible playbook. You can add your personnal
public key to the /var/mains.yml files contained in the role folder to do so.

### Roles
Roles are tasks run by ansible-playbook onto the hosts specified in the inventory.
#### automation-user
This role create a automation user on the target host. This user will belong in a specific group
called backup and in the group docker. You can find the backup group permission in the backup file.
By default, automation user used the lucy ssh key, and can communicate by ssh between each other.

<img src="images/automation-user playbook.jpg">

#### docker-build
This role build the jenkins docker image on the target host. This host should have docker installed
and the right to connect to the docker registry par-docker-factory-1 (maintained by the qa-factory)

<img src="images/docker-build playbook.jpg">

#### docker-deploy
Deploy a Jenkins on the host using a custom docker image located on par-docker-factory-1.
This will create two docker volumes: jenkins-log to store logs and jenkins-data to store all Jenkins data from /var/jenkins_home. This is the second volume that will be backup.
This playbook needs a password to decrypt credential secret passwords.
Just add --ask-vault-pass at the end of your playbook command so that you can enter the password.

<img src="images/docker-deploy playbook.jpg">

#### docker-installation
Simply install docker onto the target host. It will also set up correctly the credentials for the
factory docker registry.

#### filer-cron
Create a cron task for the user automation that remove backup archive if there are ten or more of
them in /data/jenkins_backup.

#### jenkins-cron
Create two cron task on the server running jenkins. One for taring /docker/var/lib/volumes/jenkins-data
and the other to send the tared backup to the filer server.

<img src="images/backuping-deploy playbook.jpg">

#### jenkins-job-builder
Populate Jenkins using jenkins-job-builder.

#### restore-backup.
Download the latest jenkins backup on the filer server and deploy it on the jenkins-server. You can
specify a specific backup to restore using the environment variable backup_name.
N.B. This backup must be in /data/jenkins_backup.

<img src="images/restore-backup playbook.jpg">

### Playbooks
These are the script you run to actually run the roles on hosts.
These are pretty self explanatory. They just triggered a given role on a given group of hosts.

## How To
### Running playbook
First of all create a virtualenv and install ansible using:
```bash
mkvirtualenv ansible-env
pip install ansible
```
To run a playbook, use the following command:
```bash
ansible-playbook -v <playbook-name> -u <user> -i <inventory-path> (--ask-vault-pass)
```
* -v: verbose
* -u: The user to be used on the host (either automation or root in our case)
* -i: The path to the inventory

Playbook that can be used the automation user are the following:
* docker-deploy
* filer-cron
* jenkins-cron
* jenkins-job-builder
* restore-backup

The other ones need to be executed using the root user.

List of playbook commands :

| Playbooks  | Commands |
| ------------- | ------------- |
| Create-automation-user  | ansible-playbook create-automation-user.yml -i inventories/production -u root  |
| Docker-build  | ansible-playbook docker-build.yml -i inventories/production -u root --ask-vault-pass  |
| Docker-deploy | ansible-playbook docker-deploy.yml -i inventories/production -u automation --ask-vault-pass |
| Jenkins-job-builder | ansible-playbook jenkins-job-builder.yml -i inventories/production -u automation |
| Backuping-deploy | ansible-playbook backuping-deploy.yml -i inventories/production -u automation |
| Restore-backup | ansible-playbook restore-backup.yml -i inventories/production -u automation |
| docker-installation | ansible-playbook docker-installation.yml -u root -i inventories/production |

## Downgrade plugin version

- Update roles/docker-deploy/files/plugins.txt
- On the jenkins server go in /volume/_data/plugins
- rm -R 'your-plugin-to-downgrade'*"
- run docker-deploy playbook

## Manuals steps to do after running docker-deploy for the first time on a host
### Remove nodes
The only manual step if for remove nodes store in docker-deploy/files/nodes. To modify this folder nodes, we have to go on the host where jenkins is, go in jenkins-data/_data/nodes/ and remove manually nodes


After copy you have to restart the docker to apply those configurations by running 'docker restart jenkins-master' on the host.

### Start agents on windows
To start an agent on windows :
- From the needed computer go on the jenkins url
- Connect
- Click on the needed executor ( win32-vs2013-qa-testslot-win7 / win32-vs2013-qa-testslot-win8 / win64-vs2015-qa-testslot-win10 )
- Launch agent from browser


# Useful Links:
- [Groovy Hook Script and Jenkins Configuration as Code](http://tdongsi.github.io/blog/2017/12/30/groovy-hook-script-and-jenkins-configuration-as-code/)
- [Infrastucture documentation](https://drive.google.com/open?id=1X9uJNzDCCspRIvIg9hIJyVD0qiEaaXZ7DzJUPfqXbgc)
