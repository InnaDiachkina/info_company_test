package test.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import test.project.dto.CompanyRequestDto;
import test.project.dto.CompanyResponseDto;
import test.project.mapper.RequestDtoMapper;
import test.project.mapper.ResponseDtoMapper;
import test.project.model.Company;
import test.project.repository.CompanyRepository;
import test.project.service.impl.CompanyServiceImpl;

public class CompanyServiceImplTest {
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private RequestDtoMapper<CompanyRequestDto, Company> requestDtoMapper;
    @Mock
    private ResponseDtoMapper<CompanyResponseDto, Company> responseDtoMapper;
    @InjectMocks
    private CompanyServiceImpl companyService;
    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void add_withValidRequest_thenAddCompany() {
        CompanyRequestDto companyRequestDto = new CompanyRequestDto();
        companyRequestDto.setName("Test Company");

        Company company = new Company();
        company.setName("Test Company");

        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setName("Test Company");

        when(requestDtoMapper.mapToModel(companyRequestDto)).thenReturn(company);
        when(companyRepository.save(company)).thenReturn(company);
        when(responseDtoMapper.mapToDto(company)).thenReturn(companyResponseDto);

        CompanyResponseDto actual = companyService.add(companyRequestDto);
        assertNotNull(actual);
        assertEquals("Test Company", actual.getName());
    }

    @Test
    public void add_withInvalidRequest_thenReturnException() {
        CompanyRequestDto companyRequestDto = new CompanyRequestDto();

        when(requestDtoMapper.mapToModel(companyRequestDto))
                .thenThrow(new IllegalArgumentException("Invalid data"));

        assertThrows(IllegalArgumentException.class, () -> {
            companyService.add(companyRequestDto);
        });
    }

    @Test
    public void getAll_thenReturnAllCompanies() {
        Company company1 = new Company();
        company1.setName("Company 1");
        Company company2 = new Company();
        company2.setName("Company 2");

        CompanyResponseDto companyResponseDto1 = new CompanyResponseDto();
        companyResponseDto1.setName("Company 1");
        CompanyResponseDto companyResponseDto2 = new CompanyResponseDto();
        companyResponseDto2.setName("Company 2");

        when(companyRepository.findAll()).thenReturn(Stream.of(company1, company2).collect(Collectors.toList()));
        when(responseDtoMapper.mapToDto(company1)).thenReturn(companyResponseDto1);
        when(responseDtoMapper.mapToDto(company2)).thenReturn(companyResponseDto2);

        List<CompanyResponseDto> companies = companyService.getAll();
        assertNotNull(companies);
        assertEquals(2, companies.size());
        assertEquals("Company 1", companies.get(0).getName());
        assertEquals("Company 2", companies.get(1).getName());
    }

    @Test
    public void getById_withValidId_thenReturnCompany() {
        UUID companyId = UUID.randomUUID();
        Company company = new Company();
        company.setId(companyId);
        company.setName("Test Company");

        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setId(companyId);
        companyResponseDto.setName("Test Company");

        when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));
        when(responseDtoMapper.mapToDto(company)).thenReturn(companyResponseDto);

        CompanyResponseDto actual = companyService.getById(companyId);
        assertNotNull(actual);
        assertEquals(companyId, actual.getId());
        assertEquals("Test Company", actual.getName());
    }

    @Test
    public void getById_withInvalidId_thenReturnException() {
        UUID companyId = UUID.randomUUID();

        when(companyRepository.findById(companyId)).thenReturn(Optional.empty());

        RuntimeException actual = assertThrows(RuntimeException.class, () -> {
            companyService.getById(companyId);
        });
        assertEquals("Company with id: " + companyId + " not found",
                actual.getMessage());
    }

    @Test
    public void update_withValidRequest_thenUpdateCompany() {
        UUID companyId = UUID.randomUUID();
        Company company = new Company();
        company.setId(companyId);
        company.setName("Old Name");

        CompanyRequestDto companyRequestDto = new CompanyRequestDto();
        companyRequestDto.setName("New Name");

        Company updatedCompany = new Company();
        updatedCompany.setId(companyId);
        updatedCompany.setName("New Name");

        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setId(companyId);
        companyResponseDto.setName("New Name");

        when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));
        when(companyRepository.save(company)).thenReturn(updatedCompany);
        when(responseDtoMapper.mapToDto(updatedCompany)).thenReturn(companyResponseDto);

        CompanyResponseDto actual = companyService.update(companyId, companyRequestDto);
        assertNotNull(actual);
        assertEquals(companyId, actual.getId());
        assertEquals("New Name", actual.getName());
    }

    @Test
    public void update_withInvalidRequest_thenReturnException() {
        UUID companyId = UUID.randomUUID();
        CompanyRequestDto companyRequestDto = new CompanyRequestDto();
        companyRequestDto.setName("New Name");

        when(companyRepository.findById(companyId)).thenReturn(Optional.empty());

        RuntimeException actual = assertThrows(RuntimeException.class, () -> {
            companyService.update(companyId, companyRequestDto);
        });
        assertEquals("Company with id: " + companyId + " not found",
                actual.getMessage());
    }

    @Test
    public void delete_withValidId_thenDeleteCompany() {
        UUID companyId = UUID.randomUUID();
        doNothing().when(companyRepository).deleteById(companyId);

        companyService.delete(companyId);
        verify(companyRepository, times(1)).deleteById(companyId);
    }

    @Test
    public void delete_withInvalidId_thenReturnException() {
        UUID companyId = UUID.randomUUID();
        doThrow(new RuntimeException("Delete failed")).when(companyRepository)
                .deleteById(companyId);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            companyService.delete(companyId);
        });

        assertEquals("Delete failed", exception.getMessage());
    }
}