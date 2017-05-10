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
        echo 'SonarQube analysis starting ...................'
        withSonarQubeEnv('Sonar-6.3') { 
          bat 'sonar-scanner'
        }        
        echo 'SonarQube analysis completed successfully ...................'
        echo 'http://localhost:9000/projects/'
      }
    }    
    stage('Launch Sonar') {
      steps {
        bat 'start http://localhost:9000/projects/'
      }
    }
  }
}
