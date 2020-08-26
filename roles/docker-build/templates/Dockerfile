FROM jenkins/jenkins:"{{jenkins_version}}"
LABEL maintainer="qafactory"

USER root
RUN apt-get update
RUN apt-get install nano
RUN apt-get install -y python
RUN apt-get install -y python-pip
RUN pip install virtualenv
RUN mkdir /var/log/jenkins
RUN mkdir /var/cache/jenkins
RUN chown -R jenkins:jenkins /var/log/jenkins
RUN chown -R jenkins:jenkins /var/cache/jenkins

ENV JAVA_OPTS=""{{ java_opts }}""
ENV JENKINS_OPTS=""{{ jenkins_opts }}""
