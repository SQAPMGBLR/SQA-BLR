pipeline {
  agent any
  stages {
    stage('Manage Code') {
      steps {
        svn(url: 'svn://10.248.4.109/SQA/SQA2017/SDLC Automation/Dynamic/Code/ELibrary-dev', poll: true)
      }
    }
  }
}