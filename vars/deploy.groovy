def call(String imageName, String tag, int port = 8000) {
    sh """
    # Stop and remove existing container if running
    # docker ps -q --filter "ancestor=${imageName}:${tag}" | xargs -r docker stop
    # docker ps -a -q --filter "ancestor=${imageName}:${tag}" | xargs -r docker rm

    # Run new container
    docker run -d -p ${port}:${port} ${imageName}:${tag}
    """

    echo "✅ Deployment successful for ${imageName}:${tag}"
}
