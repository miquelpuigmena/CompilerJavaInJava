.global _start
.text
_start:
	movq $0, %rdi
	movq $60, %rax
	syscall
