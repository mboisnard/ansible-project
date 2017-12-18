import jenkins.model.*

def executorsNumber = 5

Jenkins.instance.setNumExecutors(executorsNumber)