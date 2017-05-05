pipeline {
  agent any
  stages {
    stage('Assign Tasks') {
      steps {
        echo 'Tasks assigned on Redmine'
      }
    }
    stage('Code') {
      steps {
        echo 'Check out code from Source Code control tool '
      }
	  steps {
        echo 'Perform Static Code Analysis'
      }
	   steps {
        echo 'Check in Code'
      }
    }
    stage('Build') {
      steps {
        echo 'Build using Maven'
      }
    }
	 stage('Test') {
      steps {
        echo 'Test using Selenium'
      }
    }
	 stage('Deploy') {
      steps {
        echo 'Deploy using Jenkins to Web server'
      }
    }
  }
}
