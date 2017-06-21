/*
 * Copyright 2017 Gruas Romano S.R.L
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package edu.pucmm.mineriadedatos2017.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.type.EnumType;

import java.sql.Types;
import java.util.Properties;

/**
 * Created by gusta on 12/22/2016.
 */
public class HibernateVarcharEnum extends EnumType {
    private static final Logger LOGGER = LogManager.getLogger();

    public void setParameterValues(Properties parameters) {
        parameters.setProperty(TYPE, "" + Types.VARCHAR);
        super.setParameterValues(parameters);
    }
}
