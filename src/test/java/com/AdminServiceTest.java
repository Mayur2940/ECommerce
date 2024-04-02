package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Ecommerce.dto.UserDTO;
import com.Ecommerce.entity.AdminEntity;
import com.Ecommerce.repository.AdminRepository;
import com.Ecommerce.service.AdminService;
import com.Ecommerce.serviceimpl.AdminServiceImpl;

public class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService = new AdminServiceImpl();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddAdmin() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("John");
        userDTO.setAddress("123 Main St");
        userDTO.setEmail("john@example.com");
        userDTO.setNumber("1234556776554");
        userDTO.setRole("ADMIN");
        userDTO.setUsername("john_admin");
       

        when(adminRepository.save(any(AdminEntity.class))).thenReturn(new AdminEntity());

        UserDTO result = adminService.addAdmin(userDTO);

        assertEquals(userDTO, result);
        verify(adminRepository, times(1)).save(any(AdminEntity.class));
    }

    @Test
    public void testUpdateAdmin() {
        int adminId = 1;

        UserDTO adminData = new UserDTO();
        adminData.setName("UpdatedName");

        AdminEntity existingAdmin = new AdminEntity();
        existingAdmin.setId(adminId);

        when(adminRepository.findById(adminId)).thenReturn(Optional.of(existingAdmin));
        when(adminRepository.save(any(AdminEntity.class))).thenReturn(existingAdmin);

        UserDTO result = adminService.updateAdmin(adminId, adminData);

        assertEquals(adminData, result);
        verify(adminRepository, times(1)).save(any(AdminEntity.class));
    }

    @Test
    void testDeleteAdmin() {
        int adminId = 1;

        adminService.deleteAdminById(adminId);

        verify(adminRepository, times(1)).deleteById(adminId);
    }

    @Test
    public void testGetAdminByEmail() {
        String email = "john@example.com";

        List<AdminEntity> admins = new ArrayList<>();
        AdminEntity adminEntity = new AdminEntity();
        admins.add(adminEntity);

        when(adminRepository.findByEmail(email)).thenReturn(admins);

//        List<UserDTO> result = adminService.getAdminByEmail(email);
//
//        assertEquals(1, result.size());
//        assertEquals(email, result.get(0).getEmail());
    }
}

