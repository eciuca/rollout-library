def call(String deploymentConfigName) {
    script {
        openshift.withCluster() {
            openshift.withProject(env.DEV_PROJECT) {
                openshift.selector("dc", "${deploymentConfigName}").rollout().latest()
            }
        }
    }
}
