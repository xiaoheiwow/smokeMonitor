package me.xhw.plugin.oauth2;

import me.xhw.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author admin
 */
@Component("userDetailsService")
public class BaseUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper baseUserMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        me.xhw.entity.User user = baseUserMapper.selectByAccount(name);
        if(user == null){
            return null;
        }
        String[] authorities = new String[]{"if need ,i can do it"};
        return User.withUsername(user.getAccount()+"||"+user.getRealName()+"||"+user.getId()).password(user.getPassword()).authorities(authorities).build();
    }
}
