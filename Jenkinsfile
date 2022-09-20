pipeline{
  agent any
  
  stages {
  stage('sanity checks') {
      steps {
        sh "echo ${ghprbActualCommit}"
        sh "echo ${env.ghprbActualCommit}"
        sh "echo ${sha1}"
        sh "echo ${env.sha1}"
        sh "echo ${HEAD_BRANCH}"
        sh "echo ${env.HEAD_BRANCH}"
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
