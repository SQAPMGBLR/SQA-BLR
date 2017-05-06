pipeline {
  agent any
  stages {
    stage('Checkout from SCM') {
      steps {
        echo 'Building Proj from SCM'
        git(url: 'https://github.com/SQAPMGBLR/SQA-BLR.git', branch: 'master', credentialsId: 'sqapmgblr', poll: true)
      }
    }
    stage('Build') {
      steps {
        echo 'Building the project'
        bat 'sonar-scanner'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deployed the project'
      }
    }
  }
}