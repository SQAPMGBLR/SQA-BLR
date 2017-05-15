pipeline {
  agent any
  stages {
    stage('Checkout from SCM') {
      steps {
        echo 'Building Proj from SCM'
        echo 'Successfully checkedout project from Github'
        bat 'checkout([$class: \'SubversionSCM\', additionalCredentials: [], excludedCommitMessages: \'\', excludedRegions: \'\', excludedRevprop: \'\', excludedUsers: \'\', filterChangelog: false, ignoreDirPropChanges: false, includedRegions: \'\', locations: [[credentialsId: \'c896fcdd-f489-41f3-aaa2-32970a30b854\', depthOption: \'infinity\', ignoreExternalsOption: true, local: \'.\', remote: \'svn://10.248.4.109/SQA/SQA2017/SDLC Automation/Dynamic/Code/ELibrary-dev\']], workspaceUpdater: [$class: \'UpdateUpdater\']])'
      }
    }
    stage('Sonarqube Analysis') {
      steps {
        echo 'SonarQube analysis started .....'
        bat 'sonar-scanner'
        echo 'SonarQube analysis completed successfully .....'
      }
    }
    stage('Launch Sonarqube') {
      steps {
        bat 'start http://localhost:9000/projects/'
      }
    }
  }
}