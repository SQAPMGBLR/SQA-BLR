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
      node {
              withSonarQubeEnv('Sonarqube 6.3.1') {
                 sh 'mvn clean package sonar:sonar'
              }
          }
      
    }
    stage('SonarQube Quality Gate') {
      steps {
        echo 'Waiting for the Quality Gate'
        timeout(time: 1, unit: 'HOURS') { 
           
        }
      }
      
    }
  }
}
