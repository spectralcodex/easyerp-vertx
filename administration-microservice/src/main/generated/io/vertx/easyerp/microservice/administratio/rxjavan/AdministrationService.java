/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.easyerp.microservice.administratio.rxjavan;

import rx.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.easyerp.microservice.administration.jpojo.User;

/**
 * A service interface managing products.
 * <p>
 * This service is an event bus service (aka. service proxy)
 * </p>
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.easyerp.microservice.administration.AdministrationService original} non RX-ified interface using Vert.x codegen.
 */

@io.vertx.lang.rxjava.RxGen(io.vertx.easyerp.microservice.administration.AdministrationService.class)
public class AdministrationService {

  public static final io.vertx.lang.rxjava.TypeArg<AdministrationService> __TYPE_ARG = new io.vertx.lang.rxjava.TypeArg<>(
    obj -> new AdministrationService((io.vertx.easyerp.microservice.administration.AdministrationService) obj),
    AdministrationService::getDelegate
  );

  private final io.vertx.easyerp.microservice.administration.AdministrationService delegate;
  
  public AdministrationService(io.vertx.easyerp.microservice.administration.AdministrationService delegate) {
    this.delegate = delegate;
  }

  public io.vertx.easyerp.microservice.administration.AdministrationService getDelegate() {
    return delegate;
  }

  /**
   * @param resultHandler the result handler will be called as soon as the initialization has been accomplished. The async result indicates whether the operation was successful or not.
   * @return 
   */
  public AdministrationService initializePersistence(Handler<AsyncResult<Void>> resultHandler) { 
    delegate.initializePersistence(resultHandler);
    return this;
  }

  /**
   * @return 
   */
  public Single<Void> rxInitializePersistence() { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      initializePersistence(fut);
    }));
  }

  /**
   * Add a product to the persistence.
   * @param user a product entity that we want to add
   * @param resultHandler the result handler will be called as soon as the product has been added. The async result indicates whether the operation was successful or not.
   * @return 
   */
  public AdministrationService addUser(User user, Handler<AsyncResult<User>> resultHandler) { 
    delegate.addUser(user, resultHandler);
    return this;
  }

  /**
   * Add a product to the persistence.
   * @param user a product entity that we want to add
   * @return 
   */
  public Single<User> rxAddUser(User user) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      addUser(user, fut);
    }));
  }

  public AdministrationService retrieveUser(String userId, Handler<AsyncResult<User>> resultHandler) { 
    delegate.retrieveUser(userId, resultHandler);
    return this;
  }

  public Single<User> rxRetrieveUser(String userId) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      retrieveUser(userId, fut);
    }));
  }


  public static AdministrationService newInstance(io.vertx.easyerp.microservice.administration.AdministrationService arg) {
    return arg != null ? new AdministrationService(arg) : null;
  }
}
