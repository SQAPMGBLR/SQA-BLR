pipeline {
  agent any
  stages {
    stage('Checkout from SCM') {
      steps {
        echo 'Building Proj from SCM'
        git(url: 'https://github.com/SQAPMGBLR/SQA-BLR.git', branch: 'master', credentialsId: 'sqapmgblr', poll: true)
      }
    }
    stage('SonarQube analysis') {
      steps {
        echo 'SonarQube analysis'
        bat 'sonar-scanner'
        echo 'http://localhost:9000/projects/'
      }
    }
    stage('SonarQube Quality Gate') {
      steps {
        echo 'Waiting for the Quality Gate'
        waitForQualityGate()
      }
    }
    stage('Launch Sonar') {
      steps {
        bat 'start http://localhost:9000/projects/'
      }
    }
  }
}