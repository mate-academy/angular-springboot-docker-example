FROM node:12.18.3-stretch-slim
WORKDIR /usr/src/app
COPY package.json .
RUN npm i -g @angular/cli@~10.0.4
RUN npm i
COPY . .
RUN ng build
CMD ng serve --host 0.0.0.0
