#!/bin/bash

if [ $# -ne 2 ]
then
    echo "Usage: $(basename $0) PUBLIC_KEY SSH_USER"
    exit 1
fi

public_key=$1
ssh_user=$2

echo 'Copying public SSH Keys to the VM'
mkdir -p /home/$ssh_user/.ssh
chmod 700 /home/$ssh_user/.ssh
echo "$public_key" >> /home/$ssh_user/.ssh/authorized_keys
chmod -R 600 /home/$ssh_user/.ssh/authorized_keys
echo 'Host 192.168.*.*' >> /home/$ssh_user/.ssh/config
echo 'StrictHostKeyChecking no' >> /home/$ssh_user/.ssh/config
echo 'UserKnownHostsFile /dev/null' >> /home/$ssh_user/.ssh/config
chmod -R 600 /home/$ssh_user/.ssh/config