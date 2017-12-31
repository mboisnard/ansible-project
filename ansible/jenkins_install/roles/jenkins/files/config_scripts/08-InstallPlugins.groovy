import jenkins.model.*

def pluginParameter = "workflow-durable-task-step email-ext ssh-slaves jsch momentjs pipeline-build-step workflow-cps-global-lib apache-httpcomponents-client-4-api git git-server matrix-auth docker-plugin git-parameter windows-slaves pipeline-graph-analysis workflow-step-api build-with-parameters mailer structs jackson2-api jquery jquery-detached junit display-url-api bouncycastle-api workflow-job pipeline-model-extensions plain-credentials workflow-multibranch workflow-aggregator ace-editor token-macro pipeline-stage-view pipeline-milestone-step pipeline-model-api pipeline-stage-step workflow-scm-step credentials nodejs pipeline-model-definition durable-task docker-workflow script-security cloudbees-folder pipeline-model-declarative-agent authentication-tokens credentials-binding pipeline-input-step command-launcher branch-api pipeline-rest-api ssh git-client workflow-api ssh-credentials matrix-project workflow-basic-steps scm-api gradle handlebars docker-commons config-file-provider pipeline-stage-tags-metadata docker-java-api workflow-support workflow-cps antisamy-markup-formatter"
def plugins = pluginParameter.split()

installed = [] as Set

def install(id) {
  instance = Jenkins.getInstance()
  updateCenter = instance.getUpdateCenter()
  pluginManager = instance.getPluginManager()

  plugin = updateCenter.getPlugin(id)

  plugin.dependencies.each {
    install(it.key)
  }

  if (!pluginManager.getPlugin(id) && !installed.contains(id)) {
    pluginManager.install([id], false).each { it.get() }
    installed.add(id)
  }
}

plugins.each {
  install(it)
}

instance.save()
instance.doSafeRestart()