pipeline{
  agent any
  
  stages {
  stage('sanity checks') {
      steps {
        cleanWs() // clean jenkins so it re-clones
        sh "echo ${ghprbActualCommit}"
        sh "echo ${ghprbSourceBranch}"
        sh 'git branch'
        sh "git checkout ${ghprbSourceBranch}"
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
