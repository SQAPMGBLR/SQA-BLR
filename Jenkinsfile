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
      }
    }
    stage('Launch Sonar') {
      node {
        
   publishHTML (target: [
      allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: true,
      reportDir: 'coverage',
      reportFiles: 'http://localhost:9000/dashboard?id=NTT%3ALibrary-key',
      reportName: "RCov Report"
    ])
   }
                 
      steps {
        bat start chrome.exe http://localhost:9000/projects/
        httpRequest(url: 'http://localhost:9000/projects/', acceptType: 'TEXT_HTML', contentType: 'TEXT_HTML', httpMode: 'GET')
      }
    }
  }
}
