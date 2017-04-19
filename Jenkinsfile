pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        build(quietPeriod: 3, job: 'gate')
      }
    }
    stage('unit test') {
      steps {
        echo 'deployed'
      }
    }
    stage('acceptance test') {
      steps {
        echo 'acceptance test'
      }
    }
    stage('deploy') {
      steps {
        echo 'deploy'
      }
    }
  }
}