FROM node:6.11.4
ADD src/ /
RUN apt-get update && apt-get -y install vim && npm install -g grunt &&  npm install -g grunt-cli && npm install -g bower && npm install -g typings
RUN echo '{ "allow_root": true }' > /root/.bowerrc
ENTRYPOINT cd main/client && grunt serve