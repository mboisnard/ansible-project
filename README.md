!! Booter sur un kernel 4.11 VirtualBox not work with Kernel 4.13
!! Utiliser Ansible 2.4 (sudo apt-add-repository ppa:ansible/ansible && sudo apt-get update && sudo apt-get install ansible)

vagrant up

// Add ssh key to known_hosts
ansible master -i ansible/hosts -m ping
ansible slave -i ansible/hosts -m ping

ansible-playbook ansible/docker_install/docker_install.yml -i ansible/hosts

ansible-playbook ansible/docker_registry/docker_registry.yml -i ansible/hosts

ansible-playbook ansible/docker_swarm/docker_swarm.yml -i ansible/hosts

ansible-playbook ansible/docker_swarm_deploy/docker_swarm_deploy.yml -i ansible/hosts

ansible-playbook ansible/jenkins_install/jenkins_install.yml -i ansible/hosts

vagrant destroy

!! subl ~/.ssh/known_hosts <- supprimer les clés ssh à chaque vagrant up