/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.cmmn.api.runtime;

import java.util.Map;

import org.flowable.cmmn.api.CmmnRuntimeService;

/**
 * A builder API to delete a manually created case start event subscription which was created and registered using the
 * {@link CmmnRuntimeService#createCaseInstanceStartEventSubscriptionBuilder()} builder API.
 * With this API you can delete one or more such subscriptions based on the correlation parameter values and event type.
 *
 * @author Micha Kiener
 */
public interface CaseInstanceStartEventSubscriptionDeletionBuilder {

    /**
     * Set the case definition using its specific id the manually created subscription is based on. This is mandatory and must be provided.
     *
     * @param caseDefinitionId the id of the case definition the subscription is based on (an exact version of it)
     * @return the builder to be used for method chaining
     */
    CaseInstanceStartEventSubscriptionDeletionBuilder caseDefinitionId(String caseDefinitionId);
    
    /**
     * Set the tenant id in case you are running in a multi tenant environment and the event model needs to be retrieved from a specific tenant.
     *
     * @param tenantId the id of the tenant the subscription is created for
     * @return the builder to be used for method chaining
     */
    CaseInstanceStartEventSubscriptionDeletionBuilder tenantId(String tenantId);

    /**
     * Adds a specific correlation parameter value for the subscription to be deleted. If you register the same correlation parameter values
     * as when creating and registering the event subscription, only that particular one will be deleted with this builder.
     * If you want to delete all manually created subscriptions, don't register any correlation parameter values, which would result in all matching
     * the provided case definition and event-registry start event will be deleted.
     *
     * @param parameterName the name of the correlation parameter
     * @param parameterValue the value of the correlation parameter
     * @return the builder to be used for method chaining
     */
    CaseInstanceStartEventSubscriptionDeletionBuilder addCorrelationParameterValue(String parameterName, Object parameterValue);

    /**
     * Registers a list of correlation parameter values for the subscription(s) to be deleted.
     *
     * @param parameters the map of correlation parameter values to be registered for the subscription
     * @return the builder to be used for method chaining
     */
    CaseInstanceStartEventSubscriptionDeletionBuilder addCorrelationParameterValues(Map<String, Object> parameters);

    /**
     * Deletes all the matching event subscriptions.
     */
    void deleteSubscriptions();
}
