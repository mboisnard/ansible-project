new File("/var/lib/jenkins/jobs/Devops Project").mkdir()

new File("/var/lib/jenkins/jobs/Devops Project/config.xml") << new File('/home/ubuntu/jenkins/job/jenkins_job.xml').bytes