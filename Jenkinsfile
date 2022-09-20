pipeline{
  agent any
  
  stages {
  stage('sanity checks') {
      steps {
        sh 'git branch'
        sh 'git status'
        sh 'git log'
      }
  }
  stage('maven install') {
    steps {
      // if jenkinsfile out of code base it git clone here
      withMaven(maven: 'Maven3') {
        sh 'mvn clean install'
      }
    }
  }
  
  }
}
