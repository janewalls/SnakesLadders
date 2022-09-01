pipeline{
  agent any
  
  stages {
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
