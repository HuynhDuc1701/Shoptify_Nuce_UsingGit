package com.nextpay.vimo.service;

import com.nextpay.vimo.model.auth.Role;

public interface IRoleService extends IGeneralService<Role>{
    Role findByName(String name);
}
