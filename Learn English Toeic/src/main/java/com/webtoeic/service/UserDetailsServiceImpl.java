package com.webtoeic.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webtoeic.entities.NguoiDung;
import com.webtoeic.entities.VaiTro;
import com.webtoeic.repository.NguoiDungRepository;

// cung cap thong tin ve nguoi dung va cac vai tro cua ho cho qua trình xác thực
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private NguoiDungRepository repo;

	// phuong thuc nay dung de tim kiem thong tin nguoi dung cu the
	// ket qua tra ve la mot doi tuong UserDetails (bao gồm tên đăng nhập, mật khẩu được mã hóa và danh sách vai trò)
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		NguoiDung nguoiDung = repo.findByEmail(username);
		if (nguoiDung == null) {
			throw new UsernameNotFoundException("User with email " + username + " was not be found");
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		VaiTro vaiTro = nguoiDung.getVaiTro();
		grantedAuthorities.add(new SimpleGrantedAuthority(vaiTro.name()));
		return new User(username, nguoiDung.getPassword(), grantedAuthorities);
	}
}
