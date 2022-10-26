pipeline{
  agent any

  environment {
      DB_RELEASE_URL = credentials('diffblue-cover-release-url')
  }

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

  stage('dcover create tests') {
      steps {
        sh 'mkdir --parents dcover'
        sh 'wget "$DB_RELEASE_URL" --output-document dcover/dcover.zip --quiet'
        sh 'unzip -o dcover/dcover.zip -d dcover'
        sh 'DCOVER_SCRIPT_LOCATION="dcover/dcover"'

        sh '"$DCOVER_SCRIPT_LOCATION" --version'
      }
    }
  
  }
}

// To make changes in jenkins stuff - https://plugins.jenkins.io/ghprb/
