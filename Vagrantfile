VAGRANTFILE_API_VERSION = '2'

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  # Read SSH Public Key
  local_user_home  = File.expand_path('~') 
  local_public_key = File.read("#{local_user_home}/.ssh/id_rsa.pub")

  ### Global Settings ###

  # Share folder to VM synced_folder "host path", "mounted path", options
  config.vm.synced_folder "./", "/vagrant", disabled:true
  config.vm.synced_folder "./", "/home/vagrant/sync", disabled:true
  config.ssh.insert_key = false


  ### VM ###

  # Master-Esgi Settings
  config.vm.define "master-esgi", primary: true do |master|

    # Base Image on Vagrant Cloud
    master.vm.box = "ubuntu/trusty64"

    # Hostname
    master.vm.hostname = "master-esgi"

    # Private IP
    master.vm.network "private_network", ip: "192.168.56.210"

    # Virtual Box Settings
    master.vm.provider :virtualbox do |vb|
      vb.name = "master-esgi"
      vb.cpus = 1 #2
      vb.memory = 2048 #4096
    end

    # Custom shell script
    master.vm.provision :shell, :inline =>"
      echo 'Copying public SSH Keys to the VM'
      mkdir -p /home/ubuntu/.ssh
      chmod 700 /home/ubuntu/.ssh
      echo '#{local_public_key}' >> /home/ubuntu/.ssh/authorized_keys
      chmod -R 600 /home/ubuntu/.ssh/authorized_keys
      echo 'Host 192.168.*.*' >> /home/ubuntu/.ssh/config
      echo 'StrictHostKeyChecking no' >> /home/ubuntu/.ssh/config
      echo 'UserKnownHostsFile /dev/null' >> /home/ubuntu/.ssh/config
      chmod -R 600 /home/ubuntu/.ssh/config
      echo 'Update packages list'
      apt-get update
      echo 'Install Python 2.7'
      apt-get install -y python
    ", privileged: true
  end

  # Slave-Esgi Settings
  config.vm.define "slave-esgi" do |slave|

    slave.vm.box = "centos/7"
    slave.vm.hostname = "slave-esgi"
    slave.vm.network "private_network", ip: "192.168.56.211"

    slave.vm.provider :virtualbox do |vb|
      vb.name = "slave-esgi"
      vb.cpus = 1 #2
      vb.memory = 2048 #4096
    end

    slave.vm.provision :shell, :inline =>"
      echo 'Copying public SSH Keys to the VM'
      mkdir -p /home/vagrant/.ssh
      chmod 700 /home/vagrant/.ssh
      echo '#{local_public_key}' >> /home/vagrant/.ssh/authorized_keys
      chmod -R 600 /home/vagrant/.ssh/authorized_keys
      echo 'Host 192.168.*.*' >> /home/vagrant/.ssh/config
      echo 'StrictHostKeyChecking no' >> /home/vagrant/.ssh/config
      echo 'UserKnownHostsFile /dev/null' >> /home/vagrant/.ssh/config
      chmod -R 600 /home/vagrant/.ssh/config
      echo 'Install Net-Tools'
      yum install -y net-tools
    ", privileged: true
  end
end