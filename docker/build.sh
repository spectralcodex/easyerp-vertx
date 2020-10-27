#!/usr/bin/env bash

set -e

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

docker build -t "ms-impala/api-gateway" $DIR/../api-gateway
docker build -t "ms-impala/administration-microservice" $DIR/../administration-microservice
docker build -t "ms-impala/property-management" $DIR/../property-management-microservice
