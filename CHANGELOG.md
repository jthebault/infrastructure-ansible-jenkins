# Change Log
All notable changes to this project will be documented in this file.
The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## 2.1.0 - 2019-06-04
### Added
  - Add a text field in JJB to install additional libraries during sanity job

## 2.0.0 - 2019-04-16
### Added
  - Add gitlab-ci : ansible linter + --syntax-check

## 1.6.0 - 2019-04-05
### Added
  - Add extra_package parameter jj pepper 1.10

## 1.5.1 - 2019-04-03
### Fixed
  - Missing token opn nao 2.8

## 1.5.0 - 2019-04-03
### Add
  - add qisdk sanity/testbranch jobs

## 1.4.0 - 2019-03-29
### Added
  - Job opn 2.8 nao + monitor

## 1.3.0 - 2019-03-29
### Added
  - Nao robot in lockable resources

## 1.2.1 - 2019-03-26
### Fixed
  - Stop launching all jobs at the same time

## 1.2.0 - 2019-03-21
### Added
  - Add JJB for pepper 1.10 ota job in 2.9

## 1.1.1 - 2019-03-20
### Fixed
  - Move vision testbranch job at the end of parent testbranch job (quick workaround)

## 1.1.0 - 2019-03-19
### Added
  - Node for Pepper 1.10 computer

## 1.0.0 - 2019-03-13
### Removed
  - Job libqi python win 2.9
### Fixed
  - Monitor name for virtual job 2.8

## 0.11.0 - 2019-03-04
### Added
  - Virtual 2.8 testsuite base to JJB

## 0.10.11 - 2019-02-14
### Fixed
  - Fix missing approval

## 0.10.10 - 2019-01-28
### Fixed
  - Fixed missing token parameter in templates

## 0.10.9 - 2019-01-21
### Changed
  - Token to trig sanities remotely

## 0.10.8 - 2019-01-15
### Changed
  - Upgrade README.md with drawings

## 0.10.7 - 2019-01-11
### Changed
  - Change virtuel to virtual and linux64 to linux in parent job

## 0.10.6 - 2019-01-09
### Changed
  - Separate project for expresivity 2.9 jobs as they can't use the qi pip pkg

## 0.10.5 - 2019-01-03
### Fixed
  - The path to the Jenkinsfiles after modifications in config-groovy-jenkinsfile lib

## 0.10.4 - 2019-01-03
### Changed
  - Split opn template in two: one for 2.5 and one for 2.9
  - Add Approvals for the shared libraries
  - Remove the use of sandbox in all templates

## 0.10.3 - 2018-11-15
### Fixed
  Fix non functional jjb

## 0.10.2 - 2018-11-09
### Fixed
  Add pynaoqi_url parameterin OPP job

## 0.10.1 - 2018-11-08
### Added
  Fix trigger for OPP jobs

## 0.10.0 - 2018-11-07
### Added
  Monitor for OPP jobs

## 0.9.1 - 2018-11-07
### Changed
- Update default param and remove one trigger for windows

## 0.9.0 - 2018-11-07
### Added
- Added opp jobs

## 0.8.1 - 2018-11-07
### Fixed
- Quick fixes after jenkins deployment (anonymous rights and jobs parameters)

## 0.8.0 - 2018-10-30
### Added
- Added a role to automatically install docker on ubuntu 14.04 and 16.04.

## 0.7.4 - 2018-10-30
### Fixed
- Add virtualenv as a dependency in jenkins docker image

## 0.7.3 - 2018-10-25
### Fixed
- Add missing testsuite non-functional job
- IP of a robot that came back from SAV

## 0.7.2 - 2018-10-23
### Changed
- Add a fixed version for 2.5 sanity

## 0.7.1 - 2018-10-22
### Changed
- robot password in "robot" credential

## 0.7.0 - 2018-10-16
### Added
- robot2.5 credential

## 0.6.2 - 2018-10-08
### Added
- add shared library configuration
- set right to nodes folder

## 0.6.1 - 2018-10-05
### Added
- Change qa_factory credential

## 0.6.0 - 2018-10-04
### Added
- Add nodes / scriptApprovals / lockableResources configuration on deploy
- Add Monitor and YetAnotherDocker conf in roles/docker-deploy/files

## 0.5.0 - 2018-09-25
### Added
- Add triggers

## 0.4.1 - 2018-09-26
### Changed
- Change password of jenkins credential

## 0.4.0 - 2018-09-20
### Added
- Add robot-settings jobs

### Removed
- Remove unused jobs

## 0.3.0 - 2018-09-17
### Added
- Add credentials during docker-deploy, the playbook now needs a password to
decrypt encrypted credentials passwords. (playbook option --ask-vault-pass)

## 0.2.1 - 2018-09-10
### Changed
- Add active directory plugin for SSO connexion

## 0.2.0 - 2018-09-12

### Added
- Add pretty parsing on output

### Changed
- Update the list of jobs that jenkins-job-builder will build at start

***

## 0.1.3 - 2018-09-10
### Changed
- Remove jenkins job builder cache on jenkins-job-builder ansible task

***

## 0.1.2 - 2018-09-06
### Changed
- Update and clean plugins list
- Use lts jenkins version

***

## 0.1.1 - 2018-09-03
### Fixed
- Fix ownership issue to restore jenkins backup

***

## 0.1.0 - 2018-08-29
### Added
- Jenkins server is now populated automatically with jobs during docker deployement

***
## Unreleased

### Added
- None
### Changed
- None
### Deprecated
- None
### Removed
- None
### Fixed
- None
### Security
- None
### Known Issues
- None
