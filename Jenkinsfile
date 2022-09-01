pipeline{
  agent any
  
  stages {
  stage('maven install') {
    steps {
      // if jenkinsfile out of code base it git clone here
      withMaven(globalMavenSettingsConfig: 'null', jdk: 'null', maven: 'Maven3', mavenSettingsConfig: 'null') {
        sh 'mvn clean install'
      }
    }
  }
  
  }
}
