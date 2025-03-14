/*
 *
 *  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.apimgt.rest.api.common;

import org.wso2.carbon.apimgt.impl.APIManagerConfiguration;
import org.wso2.carbon.apimgt.rest.api.common.internal.ServiceReferenceHolder;
import org.wso2.carbon.apimgt.common.gateway.dto.TokenIssuerDto;
import org.wso2.carbon.apimgt.impl.jwt.JWTValidator;

import java.util.Map;

public class APIMConfigUtil {

    private static APIManagerConfiguration configuration = getApiManagerConfiguration();

    /**
     * This is to get JWT audiences with basepaths from deployment.toml file
     * @return List of Audiences with basepath
     */
    public static Map<String, String> getRestApiJWTAuthAudiences() {
        return configuration.getRestApiJWTAuthAudiences();
    }

    /**
     * This is to get JWT issuer details from deployment.toml file
     * @return Map<issuer, tokenIssuerDto>
     */
    public static Map<String, TokenIssuerDto> getTokenIssuerMap() {
        return configuration.getJwtConfigurationDto().getTokenIssuerDtoMap();
    }

    /**
     * @return APIManagerConfiguration
     */
    private static APIManagerConfiguration getApiManagerConfiguration() {
        return ServiceReferenceHolder.getInstance().getAPIMConfiguration();
    }

    public static  Map<String, JWTValidator> getJWTValidatorMap (){
        return ServiceReferenceHolder.getInstance().getJwtValidatorMap();
    }
}
