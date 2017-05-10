pipeline {
  agent any
  stages {
    stage('Checkout from SCM') {
      steps {
        echo 'Building Proj from SCM'
        git(url: 'https://github.com/SQAPMGBLR/SQA-BLR.git', branch: 'master', credentialsId: 'sqapmgblr', poll: true)
        echo 'Successfully checkedout project from Github'
      }
    }
    stage('Sonarqube Analysis') {
      steps {
        echo 'SonarQube analysis started .....'
        bat 'sonar-scanner'
        echo 'SonarQube analysis completed successfully .....'
      }
    }
  }
}