FROM ngnix:latest
RUN sed -i 's/nginx/ac2i/g' /usr/share/nginx/html/index.html
EXPOSE 80