pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            mail to: 'amanmadaan30@gmail.com',
                 subject: "Build SUCCESS: ${env.JOB_NAME}",
                 body: "Good job! Jenkins build ${env.BUILD_NUMBER} succeeded."
        }
        failure {
            mail to: 'amanmadaan30@gmail.com',
                 subject: "Build FAILED: ${env.JOB_NAME}",
                 body: "Uh oh! Jenkins build ${env.BUILD_NUMBER} failed. Check logs."
        }
    }
}
