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

// To make changes in jenkins stuff - https://plugins.jenkins.io/ghprb/
