.global _start
.data
buf: .skip 1024
.text
_start:
	movq $0, %rdi
	movq $buf, %rsi
	movq $1024, %rdx
	movq $0, %rax
	syscall

	pushq %rax
	pushq $buf
	

	call print_string


	movq $0, %rdi
	movq $60, %rax
	syscall

print_string:
        pushq %rbp
        movq %rsp, %rbp
        movq $1, %rdi
        movq 16(%rbp), %rsi
        movq 24(%rbp), %rdx
        movq $1, %rax
        syscall
        popq %rbp
        ret

