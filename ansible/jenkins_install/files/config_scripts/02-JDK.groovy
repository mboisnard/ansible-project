import jenkins.model.*

def jdkName = "jdk8"
def jdkPath = "/usr/lib/jvm/java-8-openjdk-amd64"

def jdk = new hudson.model.JDK(jdkName, jdkPath)
def jdkList = []
jdkList.add(jdk)

Jenkins.instance.setJDKs(jdkList)