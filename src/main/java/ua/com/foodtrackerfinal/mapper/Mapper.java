package ua.com.foodtrackerfinal.mapper;

import javax.management.relation.RoleNotFoundException;

public interface Mapper<A,B> {
    B transform(A from) throws RoleNotFoundException;
}
