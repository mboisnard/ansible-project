#!/bin/bash

# Install
sudo apt-add-repository ppa:ansible/ansible
sudo apt-get update
sudo apt-get install ansible vagrant

# Vagrant vm provisioning
vagrant up

# Ansible playbooks
ansible master -i ansible/hosts -m ping
ansible slave -i ansible/hosts -m ping

ansible-playbook ansible/docker_install/docker_install.yml -i ansible/hosts

ansible-playbook ansible/docker_registry/docker_registry.yml -i ansible/hosts

ansible-playbook ansible/docker_swarm/docker_swarm.yml -i ansible/hosts

ansible-playbook ansible/docker_swarm_deploy/docker_swarm_deploy.yml -i ansible/hosts

ansible-playbook ansible/jenkins_install/jenkins_install.yml -i ansible/hosts

# Remove vm
vagrant destroy