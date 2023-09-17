package com.personal.vrpapi.core.authorization.converter;

import com.personal.vrpapi.core.authorization.dto.request.UserRequest;
import com.personal.vrpapi.core.authorization.dto.response.UserData;
import com.personal.vrpapi.core.base.entity.AbstractUser;

public interface UserConverter {

    /**
     * convert User to UserData
     * @param user
     * @return UserData
     */
    UserData convertUserToUserData(AbstractUser user);

    /**
     * convert UserRequest to AbstractUser (DRIVER, CUSTOMER) base on RoleEnum on UserRequest
     * @param request
     * @return AbstractUser (dType : Driver, Customer)
     */
    AbstractUser convertUserRequestToUser(UserRequest request);
}
