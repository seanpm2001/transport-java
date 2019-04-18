/*
 * Copyright 2019 VMware, Inc. All rights reserved. -- VMware Confidential
 */
package com.vmware.bifrost.bus.store.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.reactivex.functions.Consumer;

public interface BusStore<T> {

   /**
    * Place an object into the store, will broadcast to all subscribers online for state changes.
    * @param id, the UUID of your object.
    * @param value, the object to be added ot the store
    * @param state, the state change event you want to broadcast with this action
    *               (created, updated etc).
    */
   <State> void put(UUID id, T value, State state);

   /**
    * Retrieve an object from the store
    * @param id, the UUID of the object you wish to get.
    * @return the object you're looking for.
    */
   T get(UUID id);

   /**
    * Get all values from sotre.
    * @return {@link List<T>} with every item in the store.
    */
   List<T> allValues();

   /**
    * Get the entire store as a map.
    * @return {@link Map<UUID, T>}
    */
   Map<UUID, T> allValuesAsMap();

   /**
    * Remove an object from the store.
    * @param id, the UUID of the object to be removed.
    * @param state, the state to be sent to subscribers notifying store deletion.
    * @return true if the object was removed, false if not.
    */
    <State> boolean remove(UUID id , State state);

   /**
    * Send a mutation command to any subscribers handling mutations.
    * @param mutationRequest, mutation request describing what store value(s) that should be mutated.
    * @param mutationType, the type of the mutation.
    * @param successHandler, handler which will be invoked if the mutation operation was successful.
    * @param errorHandler, handler which will be invoked if the mutation operation fails.
    * @return true if mutation command was placed in stream
    */
   <MutationRequestType, MutationType> boolean mutate(
         MutationRequestType mutationRequest, MutationType mutationType,
         Consumer<Object> successHandler, Consumer<Object> errorHandler);

   /**
    * Populate the store with a collection of objects and their ID's.
    * @param items, a Map of your UUID's mapped to your Objects.
    * @return false if the store has already been populated (has objects).
    */
   boolean populate(Map<UUID, T> items);

   /**
    * Returns {@link BusStoreInitializer} instance which can be used to add
    * the initial items to the store. The BusStoreInitializer can be used as an
    * alternative to the populate() API.
    * @return null if the store was already initialized.
    */
   BusStoreInitializer<T> getBusStoreInitializer();

   /**
    * Subscribe to state changes for a specific object.
    * @param id, the UUID of the object you wish to receive updates.
    * @param stateChangeType, optional state change types you wish to listen to
    * @return {@link StoreStream<T>} stream that will tick the object you're online for.
    */
   <State> StoreStream<T> onChange(UUID id, State... stateChangeType);

   /**
    * Subscribe to state changes for all objects in the store.
    * @param stateChangeType, optional state change types you wish to listen to
    * @return {@link StoreStream<T>} stream that will tick the object you're online for.
    */
   <State> StoreStream<T> onAllChanges(State... stateChangeType);

   /**
    * Subscribe to mutation requests via mutate()
    * @param mutationType, optional mutation types
    * @return stream that will tick mutation requests you're online for.
    */
   <MutationType, MutationRequestType> MutateStream<MutationRequestType>
         onMutationRequest(MutationType... mutationType);

   /**
    * Notify when the store has been initialized (via populate() or initialize(), etc.)
    * @param readyFunction, handler that accepts the entire store as a map.
    */
   void whenReady(Consumer<Map<UUID, T>> readyFunction);

   /**
    * Flip an internal bit to set the store to ready, notify all watchers.
    */
   void initialize();

   /**
    * Return true if the store is already initialized.
    */
   boolean isInitialized();

   /**
    * Will wipe all data out, in case you need a clean state.
    */
   void reset();
}
