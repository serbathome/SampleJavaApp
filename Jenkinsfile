pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'devel', url: 'https://github.com/serbathome/SampleJavaApp.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"

                // build docker container
                sh "docker build -t myapp:${currentBuild.number} ."

                // push docker container to docker hub
                // sh "docker login -u serbathome -p $DOCKER_PASSWORD"
                sh "docker tag myapp:v1 serbathome/samplejavaapp:${currentBuild.number}"
                sh "docker push serbathome/samplejavaapp:${currentBuild.number}"

            }
        }
        stage('Test') {
            steps {
                echo 'Running tests'
                // run junit tests
                sh "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
                // deploy to kubernetes
                //sh "kubectl apply -f k8s/deployment.yaml"
                //sh "kubectl apply -f k8s/service.yaml"
            }
        }
    }
}
