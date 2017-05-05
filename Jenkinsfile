pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building Proj from SCM'
        git(url: 'https://github.com/SQAPMGBLR/SQA-BLR.git', branch: 'master', credentialsId: 'sqapmgblr', poll: true)
      }
    }
    stage('Test') {
      steps {
        echo 'Testing the project'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deployed the project'
      }
    }
  }
}