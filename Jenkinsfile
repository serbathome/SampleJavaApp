pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/serbathome/SampleJavaApp.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"

                // build docker container
                sh "docker build -t myapp:v1 ."

                // push docker container to docker hub
                // sh "docker login -u serbathome -p $DOCKER_PASSWORD"
                sh "docker tag myapp.:v1 serbathome/samplejavaapp:v1"
                sh "docker push serbathome/samplejavaapp:v1"

            }
        }
        stage('Test') {
            steps {
                echo 'Running tests'
                // run junit tests
                sh "mvn test"
            }
        }
    }
}
