pipeline{
  agent any
  
  stages {
  stage('sanity checks') {
      steps {
        cleanWs() // clean jenkins so it re-clones
        checkout scm // re-clone/re-download
        sh 'git branch'
        sh "git checkout ${ghprbSourceBranch}"
        sh 'git branch'
        sh 'git status'
      }
  }
  stage('Build Project') {
    steps {
      // if jenkinsfile out of code base it git clone here
      withMaven(maven: 'Maven3') {
        sh 'mvn clean install -DskipTests'
      }
    }
  }
  
  }
}

// To make changes in jenkins stuff - https://plugins.jenkins.io/ghprb/
