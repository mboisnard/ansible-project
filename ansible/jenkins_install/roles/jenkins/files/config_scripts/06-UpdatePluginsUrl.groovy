import jenkins.model.*

Jenkins.instance.pluginManager.doSiteConfigure("https://updates.jenkins.io/update-center.json")
Jenkins.instance.pluginManager.doCheckUpdatesServer()
Jenkins.instance.getUpdateCenter().updateAllSites()