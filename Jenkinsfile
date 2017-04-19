pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        build(quietPeriod: 3, job: 'gate')
      }
    }
  }
}